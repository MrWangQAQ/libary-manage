export default[
  {
    path: '',
    component: () => import('../view/userUI/basicInformation')
  },
  {
    path: 'changeInformation',
    component: () => import('../view/userUI/changeInformation')
  },
  {
    path: 'changePassword',
    component: () => import('../view/userUI/changePassword')
  },
  {
    path: 'borrowingBook',
    component: () => import('../view/userUI/borrowingBook')
  },
  {
    path: 'borrowedRecord',
    component: () => import('../view/userUI/borrowedRecord')
  }
]
