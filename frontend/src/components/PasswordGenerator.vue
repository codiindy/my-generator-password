<template>
  <div class="p-6 bg-gray-100 shadow-sm rounded-sm w-full max-w-md">
    <form @submit.prevent="generatePassword">

      <div class="mb-4">
        <label for="word1" class="block text-sm font-medium text-gray-700 mb-2">Mot 1</label>
        <input 
          type="text" 
          v-model="word1" 
          id="word1" 
          placeholder="Entrez le premier mot" 
          required 
          class="border-gray-300 border rounded-sm py-2 px-3 w-full focus:border-pink-500 focus:ring focus:ring-pink-200 transition"
        />
      </div>

      <div class="mb-4">
        <label for="word2" class="block text-sm font-medium text-gray-700 mb-2">Mot 2</label>
        <input 
          type="text" 
          v-model="word2" 
          id="word2" 
          placeholder="Entrez le second mot" 
          required
          class="border-gray-300 border rounded-sm py-2 px-3 w-full focus:border-pink-500 focus:ring focus:ring-pink-200 transition"
        />
      </div>

      <div class="mb-4">
        <label for="length" class="block text-sm font-medium text-gray-700 mb-2">
          Longueur du mot de passe
        </label>
        <input 
          type="number" 
          v-model.number="length" 
          id="length" 
          placeholder="Minimum 12 caractères"
          min="12" 
          required
          class="border-gray-300 border rounded-sm py-2 px-3 w-full focus:border-pink-500 focus:ring focus:ring-pink-200 transition"
        />
        <p v-if="length && length < 12" class="text-sm text-red-500 mt-1">
          La longueur doit être d'au moins 12 caractères.
        </p>
      </div>

      <div class="mb-4">
        <button 
          type="submit" 
          class="w-full py-2 px-4 rounded-sm bg-pink-600 text-white font-semibold shadow-md hover:bg-pink-700 focus:outline-none focus:ring focus:ring-pink-200 transition"
        >
          Générer
        </button>
      </div>
    </form>
    <div class="mt-8 w-full">
      <p class="text-lg font-bold text-gray-800">Mot de passe généré :</p>
      
      <div class="relative">
        <input 
          type="text" 
          :value="password || ''"
          placeholder="xxxxxxxxxxxxxx"
          readonly
          class="border-pink-300 border rounded-sm py-2 px-3 pl-10 w-full cursor-pointer select-all my-4"
          id="passwordField"
        />
        <span class="mdi mdi-lock-check absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-500" :class="password ? 'text-green-500' : 'text-black'"></span>

        <button 
          @click="copyToClipboard"
          class="absolute top-1/2 right-2 transform -translate-y-1/2 text-gray-500 hover:text-gray-700">
          <span class="mdi mdi-content-copy text-xl"></span>
        </button>
      </div>
      <div class="mb-4" v-if="password">
        <button 
          type="button" 
          @click="resetFields" 
          class="w-full py-2 px-4 rounded-sm bg-gray-400 text-white font-semibold shadow-md hover:bg-gray-500 focus:outline-none focus:ring focus:ring-gray-200 transition"
        >
          Rafraichir
        </button>
      </div>
      <p v-if="copied" class="text-sm text-green-500 mt-2">Copié avec succès!</p>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import axios from 'axios'

const word1 = ref('')
const word2 = ref('')
const length = ref()
const password = ref('')
const copied = ref(false)

const generatePassword = async () => {
  if (length.value < 12) {
    console.log('La longueur du mot de passe doit être au moins de 12 caractères.')
    return
  }

  try {
    const response = await axios.post('http://localhost:8080/api/password/generate', {
      word1: word1.value,
      word2: word2.value,
      length: length.value
    })
    password.value = response.data
  } catch (error) {
    console.error('Erreur lors de la génération du mot de passe', error)
  }
}

const copyToClipboard = async () => {
  try {
    await navigator.clipboard.writeText(password.value)
    copied.value = true

    setTimeout(() => {
      copied.value = false
    }, 2000)
  } catch (err) {
    console.error('Erreur lors de la copie :', err)
  }
}

const resetFields = () => {
  word1.value = ''
  word2.value = ''
  length.value = undefined
  password.value = ''
  copied.value = false
}
</script>
