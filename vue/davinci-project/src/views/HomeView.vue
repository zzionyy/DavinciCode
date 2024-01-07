<script setup>
import router from '@/router';


function login() {
  router.push("/login");
}
</script>

<template>
  <main>
    <h2>Welcome to DavinciCode GAME!</h2>
    <button @click="login">Let's play!</button>
  </main>
</template>
