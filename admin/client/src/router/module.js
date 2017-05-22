export default [{
  path: '/dashboard',
  component: (resolve) => {
    require(['../view/Dashboard.vue'], resolve)
  }
}, {
  path: '/users',
  component: (resolve) => {
    require(['../view/UserList.vue'], resolve)
  }
}, {
  path: '/things',
  component: (resolve) => {
    require(['../view/ThingList.vue'], resolve)
  }
},
{
  path: '/demo',
  component: (resolve) => {
    require(['../view/demo.vue'], resolve)
  }
},
{
  path:'/demo2',
  component:(resolve)=>{
    require(['../view/Pie2.vue'], resolve)
  }
},
{
  path:'/table1',
  component:(resolve)=>{
    require(['../view/Table1.vue'], resolve)
  }
},
{
  path:'/table4',
  component:(resolve)=>{
    require(['../view/Table4.vue'], resolve)
  }
},
{
  path:'/gys_add',
  component:(resolve)=>{
    require(['../view/Gys_add.vue'], resolve)
  }
}
]
