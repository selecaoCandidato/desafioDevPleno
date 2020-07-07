import { api } from './api';

export default {
    handleGetBalance: async (number) => {
       return api.get(`/account/${number}`);
    },

    handleTransaction: async (id, number = '0000', type, value) => {
        return api.post(`/transaction/${id}/${number}`, {
            type,
            value,
            createdDate: new Date(),
        }, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    },

    handleExtract: async (startDate, endDate, id) => {
        return api.get(`/transaction/extract/${startDate}/${endDate}/${id}`, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }
}