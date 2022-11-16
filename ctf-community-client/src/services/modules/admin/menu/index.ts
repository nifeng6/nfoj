import request from '@/services/request'
import type { IMenuData, IDataType } from '@/types/admin/menu'

export function getMenuList() {
  return request.get<IDataType<IMenuData[]>>({
    url: '/admin/menu/list'
  })
}
