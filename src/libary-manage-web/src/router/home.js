export default[
  {
    path: 'userManage',
    component: () => import('../view/admin/userManage'),
    children: [
      {
        path: '',
        component: () => import('../view/admin/userManage/list')
      }
    ]
  },
  {
    path: 'bookAdminManage',
    component: () => import('../view/admin/bookAdminManage'),
    children: [
      {
        path: '',
        component: () => import('../view/admin/bookAdminManage/list')
      }
    ]
  },
  {
    path: 'systemAdmin',
    component: () => import('../view/admin/systemAdmin')
  }
]
