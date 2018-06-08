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
  },
  {
    path: 'borrowBook',
    component: () => import('../view/bookManageUI/borrowManage/borrowBook'),
  },
  {
    path: 'backBook',
    component: () => import('../view/bookManageUI/borrowManage/backBook'),
  },
  {
    path: 'getBorrowRecords',
    component: () => import('../view/bookManageUI/borrowManage/getBorrowRecords'),
  },
  {
    path: 'changePassword',
    component: () => import('../view/bookManageUI/borrowManage/changePassword'),
  }
]
