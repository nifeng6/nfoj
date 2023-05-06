//server.js代码
const net = require('net');
const fs = require('fs');
const process = require('child_process');


const server = net.createServer(function (connection) {
    console.log('客户端连接成功');

    connection.on('end', function () {
        console.log('客户端关闭连接');
    });


    connection.on('data', function (data) {
        const content = JSON.parse(Buffer.from(data.toString(), "base64").toString()) // 接收到的内容进行base64解码
        let run_result = ""
        console.log(content.toString())


        // 创建随机昵称
        const uuid = (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1) + (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1) + (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1)
        // 创建文件夹，附上昵称
        try {
            process.execSync("mkdir /root/run_code/" + uuid)
        } catch {
            console.log("创建文件夹失败")
        }
        // 保存收到的内容到文件中，这里需要判断是什么代码
        let result = new Object(); // 创建object对象，最后进行返回
        if (content.type == "Python3") {
            try {
                fs.writeFileSync("/root/run_code/" + uuid + "/main.py", content.code)
            } catch (e) {
                console.log("创建文件失败：" + e)
            }
            // 创建docker容器，指定/run为工作目录，指定容器名，指定容器目录映射
            try {
                process.execSync("docker run -w /run --name " + uuid + " --env LANG=C.UTF-8 -itd -v /root/run_code/" + uuid + ":/run sandbox:v1")
            } catch (e) {
                console.log("创建容器失败" + e)
            }
            // 执行代码，返回执行结果
            try {
                var begin = Date.now();
                run_result = process.execSync("docker exec " + uuid + " python3 main.py")
                var end = Date.now();
                console.log(end - begin)
                result.data = run_result.toString();
                result.run_time = end - begin
                result.run_code = 1
            } catch (e) {
                result.data = e.toString();
                result.run_code = 0
                console.log("执行代码失败" + e)
            }

        } else if (content.type == "Python") {
            fs.writeFileSync("/root/run_code/" + uuid + "/main.py", content.code)
            // 创建docker容器，指定/run为工作目录，指定容器名，指定容器目录映射
            try {
                process.execSync("docker run -w /run --name " + uuid + " --env LANG=C.UTF-8 -itd -v /root/run_code/" + uuid + ":/run sandbox:v1")
            } catch (e) {
                console.log("创建容器失败" + e)
            }
            // 执行代码，返回执行结果
            try {
                var begin = Date.now();
                run_result = process.execSync("docker exec " + uuid + " python main.py")
                var end = Date.now();
                console.log(end - begin)
                result.data = run_result.toString();
                result.run_time = end - begin
                result.run_code = 1
            } catch (e) {
                result.data = e.toString();
                result.run_code = 0
                console.log("执行代码失败" + e)
            }
        }
        else if (content.type == "JAVA") {
            fs.writeFileSync("/root/run_code/" + uuid + "/Main.java", content.code)
            // 创建docker容器，指定/run为工作目录，指定容器名，指定容器目录映射
            try {
                process.execSync("docker run -w /run --name " + uuid + " -itd --env LANG=C.UTF-8 -v /root/run_code/" + uuid + ":/run sandbox:v1")
            } catch (e) {
                console.log("创建容器失败" + e)
            }
            // 执行代码，返回执行结果
            try {
                process.execSync("docker exec " + uuid + " javac Main.java")
                var begin = Date.now();
                run_result = process.execSync("docker exec " + uuid + " java Main")
                var end = Date.now();
                console.log(end - begin)
                result.data = run_result.toString();
                result.run_time = end - begin
                result.run_code = 1
            } catch (e) {
                result.data = e.toString();
                result.run_code = 0
                console.log("执行代码失败" + e)
            }
        }



        // 编码返回结果，发送到Java客户端
        try {
            connection.write(Buffer.from(JSON.stringify(result)).toString('base64'));
        } catch (e) {
            console.log("发送数据失败" + e)
        }
        // 执行完内容，删除文件夹，容器等内容
        try {
            process.execSync("rm -rf /root/run_code/" + uuid)
            process.execSync("docker rm -f " + uuid)
        } catch (e) {
            console.log("删除失败" + e)
        }

        // 读取到消息进行处理返回数据
        // const content = fs.readFileSync('./111.txt') // 读取到文件，进行返回
    });


});



server.listen(3000, function () {
    console.log('服务器监听');
});
