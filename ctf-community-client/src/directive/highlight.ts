import hljs from 'highlight.js'

export default function (el: any) {
  let blocks = el.querySelectorAll('pre code')
  blocks.forEach((block: any) => {
    hljs.highlightBlock(block)
  })
}
