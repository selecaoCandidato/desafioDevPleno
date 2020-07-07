<template>
    <container>
      <Title>Extrato da conta</Title>
      <extract-info>
        <extract-title>Defina um intevalo de datas para gerar seu extrato</extract-title>
        <extract-container>
          
          <label for="start">De:</label>
          <date-picker name="start" :mode="single" v-model='startDate' @input="handleChangeStartDate" />
          <label for="end">Até:</label>
          <date-picker name="end" :mode="single" v-model='endDate' @input="handleChangeEndDate"/>
         
        </extract-container>
         <extract-button type="button" v-on:click="handleGenerateExtract">
            Gerar Extrato
        </extract-button>
      </extract-info>
      <extract>
        <ExtractTitle>Suas transações aparecerão aqui:</ExtractTitle>
        <extract-item v-for="item of extract" :key="item.id">
          <h4>Valor: R$ {{ item.value }}</h4>
          <h4>Data: {{ item.createdDate }}</h4>
          <h4 v-if="item.type === 'debit'">Tipo: Depósito</h4>
          <h4 v-if="item.type === 'transfer'">Tipo: Transferência</h4>
          <h4 v-if="item.type === 'credit'">Tipo: Saque realizado</h4>
        </extract-item>
      </extract>
    </container>
</template>

<script>
import { Container, Title, ExtractInfo, ExtractTitle, ExtractButton, Extract, ExtractItem, ExtractContainer} from './styles.js';
import Balance from '../../services/balance';
import DatePicker from 'v-calendar/lib/components/date-picker.umd'
import Vue from 'vue';
import moment from 'moment';
Vue.component('date-picker', DatePicker)
export default {
  name: 'Balance',

  data: function() {
    return {
      balance: [],
      extract: [],
      startDate: new Date(),
      endDate: new Date(),
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
    ExtractInfo,
    ExtractTitle,
    ExtractButton,
    DatePicker,
    Extract,
    ExtractItem,
    ExtractContainer  
  },

  methods: {

    handleGenerateExtract(){
        const id = this.balance.id;

        const formattedStartDate = moment(this.startDate).format('YYYY-MM-DD');
        const formattedEndDate = moment(this.endDate).format('YYYY-MM-DD');

        Balance.handleExtract(formattedStartDate, formattedEndDate, id).then(response => {
          if (response.data.lenght !== 0){
            response.data.map(extract => {
              const date = moment(extract.createdDate).toISOString();
              extract.createdDate = moment(date).format('DD/MM/YYYY');
            });
            this.extract = response.data;
          }
        });
    },

    handleChangeStartDate(date){
      this.startDate = date;
    },

    handleChangeEndDate(date){
      this.endDate = date;
    }
  } 
}
</script>
