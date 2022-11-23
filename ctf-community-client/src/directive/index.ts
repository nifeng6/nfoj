import type { App } from 'vue'
import highlight from './highlight'

export default function (app: App) {
  app.directive('highlight', highlight)
}
