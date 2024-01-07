import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../components/login/LoginView.vue';
import HomeView from '../views/HomeView.vue';
import LobbyView from '../components/game/LobbyView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: HomeView
    },
    {
      path: "/login",
      name: "Login",
      component: LoginView,
    },
    {
      path: "/lobby",
      name: "Lobby",
      component: LobbyView,
    }
  ]
})

export default router
