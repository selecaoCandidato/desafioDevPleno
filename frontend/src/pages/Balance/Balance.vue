<template>
    <container>
      <Title>Olá, {{ name }}<br> Qual transação gostaria de realizar hoje?</Title>
      <balance-info>
        <balance-value>Saldo: 200</balance-value>
        <Form action="#" @submit="handleCreateTransaction">
          <Input type="number" v-model="value" name="value" placeholder="Insira aqui o valor da transação" />
          <Input type="number" v-model="destinyAccountNumber" name="destinyAccountNumber" placeholder="Se for transferir, insira a conta destino" />
          <v-select :options="['Depositar', 'Sacar', 'Transferir']" @input="setSelected"></v-select>
          <form-button type="submit">
            Realizar Transação
          </form-button>
        </Form>
      </balance-info>
    </container>
</template>

<script>
import { Container, Title, BalanceInfo, BalanceValue, Form, FormButton, Input} from './styles.js';
import Balance from '../../services/balance';
import vSelect from 'vue-select';
import Vue from 'vue';
import 'vue-select/dist/vue-select.css';

Vue.component('v-select', vSelect)
export default {
  name: 'Balance',

  data: function() {
    return {
      balance: [],
      type: null,
      name: null,
      value: null,
      destinyAccountNumber: null,
    };
  },

  mounted(){
    this.name = localStorage.name;
    Balance.handleGetBalance(localStorage.number).then(response => {
      this.balance = response.data;
    });
  },

  components: {
    Container,
    Title,
    BalanceInfo,
    BalanceValue,
    Form,
    FormButton,
    Input
  },

  methods: {
    setSelected(value) {
      this.type = value;
    },

    handleCreateTransaction() {
       event.preventDefault();
      const id = this.balance.id;

      switch (this.type) {
        case 'Depositar':
          Balance.handleTransaction(id,'0000' ,'debit', this.value).then(response => {
            if (response.data !== "Você não possui saldo suficiente para esta transação") {
              alert("Valor depositado com sucesso");  
            }  
          });
          break;
        case 'Sacar':
          Balance.handleTransaction(id, '0000' ,'credit', this.value).then(response => {
            if (response.data !== "Você não possui saldo suficiente para esta transação") {
              alert("Valor sacado com sucesso");  
            }  
          });
          break;
        case 'Transferir':
          Balance.handleTransaction(id, this.destinyAccountNumber, 'transfer', this.value).then(response => {
            if (response.data !== "Você não possui saldo suficiente para esta transação") {
              alert("Valor transferido com sucesso");  
            }   
          });
          break;
      }
    }
  } 
}
</script>
