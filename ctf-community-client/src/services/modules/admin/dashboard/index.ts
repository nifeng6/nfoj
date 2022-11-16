import request from '@/services/request'
import type {
  IDataType,
  IDashboardCountListData
} from '@/types/admin/dashboard'

export function getCountList() {
  return request.get<IDataType<IDashboardCountListData>>({
    url: '/admin/dashboard/count-list'
  })
}
