import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import router from '@/router';
import axios from 'axios';

// const REST_USER_API = `http://localhost:9091/davinci/user`
export const useUserStore = defineStore('user', () => {
  
  const loginUser = ref([]);
  const getLogin = function (id) {
    axios.get("https://davinci-code.run.goorm.io/login", id)
    .then ((response) => {
      alert(`${id}님 반갑습니다.`);
      console.log(response.data);
      loginUser.value.push(id);
      console.log(loginUser.value);
      router.push(`/lobby`);
    })
  }
  return { loginUser, getLogin, }
})
