
<template>
    <div class="container">
        <label id="id">Write your name!</label>
        <div class="inputID">
            <input type="text" placeholder="ID" v-model="userId" :maxlength="10">
            <div class="confirm">10글자까지 입력 가능합니다.</div>
        </div>
        <button v-bind:disabled="userId == ''" @click="loginform()" >LogIn</button>
    </div>
</template>

<script setup>
import {useUserStore} from '@/stores/user';
import { ref } from 'vue';

const store = useUserStore();

const userId = ref('');
const user = ref({});


const loginform = function() {
    store.getLogin(userId);
}


</script>

<style>
* {
    box-sizing: border-box;
    margin: 10px;
}
#id {
    font-family: 'Courier New', Courier, monospace;
}
.container {
    background-color: bisque;
    padding: 5px;
    border-radius: 5px;
    border: 6px dotted violet;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.inputID {
    margin-bottom: 0px;
    padding-bottom: 0px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.confirm {
    margin: 0px;
    padding: 0px;
    font-size: 12px;
    font-style: italic;
}
</style>