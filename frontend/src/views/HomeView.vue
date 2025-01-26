<template>
  <main class="flex items-center justify-center min-h-screen w-full bg-gray-100 px-4">
    <div class="bg-white shadow-lg rounded-sm p-6 w-full max-w-lg flex flex-col items-center">
      <span class="mdi mdi-form-textbox-password text-6xl text-pink-600 mb-4"></span>
      <h1 class="text-3xl font-extrabold text-center text-gray-800 mb-4">
        Générateur de mots de passe
      </h1>

      <p class="text-center text-gray-600 mb-8">
        Vous voulez un mot de passe unique avec <strong>vos propres mots</strong> ? <br>
        Pas de caractères <em>compliqués</em>, juste quelque chose de <strong>personnel</strong>, mais tout de même <strong>sécurisé</strong> !
      </p>
      <PasswordGenerator />
      <div class="mt-4 text-sm font-medium text-gray-700">version 1.0.0</div>
    </div>
  </main>
</template>



<script setup lang="ts">
import PasswordGenerator from '../components/PasswordGenerator.vue';
</script>


