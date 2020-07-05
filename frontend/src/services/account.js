import { api } from './api';

export default {
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