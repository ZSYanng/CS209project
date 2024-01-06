import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter)
import page1  from '@/components/page1.vue';
import page2  from '@/components/page2.vue';
import page4 from '@/components/page4.vue';
import page5 from '@/components/page5.vue';
const routes=[

    {path:'/page1',component:page1},
    {path:"/page2",component:page2},
    {path:'/page4',component:page4},
    {path:'/page5',component:page5}
]

const router=new VueRouter({
    routes
});

export default router