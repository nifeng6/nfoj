export interface IDataType<T = any> {
    code: number
    data: T
    msg: string
    page?: IPage
  }
  
  export interface IPage {
    currentPage: number
    pageSize: number
    total: number
    pages: number
  }
  
  export interface ICodeRunParams {
    code: string
    type: string
  }
  
  export interface ICodeRun {
    content: string
    runTime: number
    code: number
  }
  
  export interface ICodeShareParams {
    content: string
    type: string
  }
  
  export interface ICodeShare {
    qrcode: string
    key: string
  }
  