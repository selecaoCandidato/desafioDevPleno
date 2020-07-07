<template>
  <a
    v-bind:href="href"
    v-bind:class="{ active: isActive }"
  >
    <slot></slot>
  </a>
</template>

<script>
  // eslint-disable-next-line no-unused-vars
  import routes from '../routes'
  export default {
    props: {
      href: String,
      // eslint-disable-next-line vue/require-prop-type-constructor
      required: true
    },
    computed: {
      isActive () {
        return this.href === window.location.pathname
      }
    }
  }
</script>

<style scoped>
  .active {
    color: cornflowerblue;
  }
</style>