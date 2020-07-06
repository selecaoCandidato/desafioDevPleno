import Vue from 'vue';
import Router from 'vue-router';
import Signin from './pages/Signin/Signin.vue';
import Balance from './pages/Balance/Balance.vue';
import Extract from './pages/Extract/Extract.vue';

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Signin',
            component: Signin
        },
        {
            path: '/balance',
            name: 'Balance',
            component: Balance
        },
        {
            path: '/extract',
            name: 'Extract',
            component: Extract
        },
    ]
});