import { api } from './api';

export default {

    // eslint-disable-next-line no-unused-vars
    handleCreateAccount: (number, responsible) => {
        api.get(`/account/${number}`).then(response => {
            if (response.data === ''){
                return api.post('/account', {
                    number,
                    responsible
                });
            }
        });
    }
}