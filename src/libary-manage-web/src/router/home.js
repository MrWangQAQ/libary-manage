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
  }
]
