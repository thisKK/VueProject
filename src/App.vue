<template>
  <div id="app">
    <manu/>
  </div>
</template>

<script>
import manu from './components/manu'
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbvue/build/css/mdb.css';
import '../public/style.css';

export default {
  name: 'app',
  components: {
    manu
  }
}
</script>

<style>

</style>
