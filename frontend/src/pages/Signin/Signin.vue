<template>
    <container>
      <Title>Desafio Java Pleno</Title>
      <form-container>
        <form-title>Entre com os dados de sua conta</form-title>
        <Form action="#" @submit="handleEntry">
          <Input type="text" v-model="name" name="name" placeholder="Insira aqui o seu nome" />
          <Input type="text" v-model="number" name="number" placeholder="Insira aqui o número da sua conta" />
          <form-button type="submit" v-on:click="handleEntry">
            Entrar
          </form-button>
        </Form>
        <p>Obs: Se a conta não existir ela será criada automaticamente</p>
      </form-container>
    </container>
</template>

<script>
import { Container, Title, FormContainer, FormTitle, Input, FormButton, Form } from './styles.js';
import Account from '../../services/account';
import router from '../../router';
export default {
  name: 'Signin',

  data: function() {
    return {
      errors: [],
      name: null,
      number: null,
    };
  },

  components: {
    Container,
    Title,
    FormContainer,
    FormTitle,
    Input,
    FormButton,
    Form
  },

  methods: {
    handleEntry: function (event) {
      if (this.name && this.age) {
        return true;
      }

      this.errors = [];

      if (!this.name) {
        alert('O nome é obrigatório.');
        this.errors.push('O nome é obrigatório.');
      }
      if (!this.number) {
        alert('O número da conta é obrigatória.');
        this.errors.push('O número da conta é obrigatória.');
      }

      event.preventDefault();
      
      Account.handleCreateAccount(this.number, this.name);

      localStorage.name = this.name;
      localStorage.number = this.number;

      router.push('/balance');
    }
  }
}
</script>