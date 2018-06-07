export default[
  {
    path: 'bookManage',
    component: () => import('../view/bookManageUI/bookManage'),
    children: [
      {
        path: '',
        component: () => import('../view/bookManageUI/bookManage/list')
      }
    ]
  }
]
