import Vue from 'vue';
import Router from 'vue-router';
import Signin from './pages/Signin/Signin.vue';
import Balance from './pages/Balance/Balance.vue';

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
    ]
});