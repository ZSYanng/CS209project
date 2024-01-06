 <template>
  <div id="app">
    <img src="./assets/PP.gif">
    <el-card class="box-card" style="width: auto;height: 500px">

       <div>
        <el-row style="height:50px" >
        <router-link to="/page1">
          <el-button type="primary">repos number
            
      </el-button></router-link>
      <router-link to="/page2">
          <el-button type="danger">issue number
      </el-button></router-link>
            <router-link to="/page4">
          <el-button type="success">open/closed issue
      </el-button></router-link>
         <router-link to="/page5">
          <el-button type="warning">forks and watchers
      </el-button></router-link>
    </el-row>
    <router-view  ></router-view >
  </div>
  </el-card >
  <el-card>
              <time-bar-vue></time-bar-vue>
  </el-card>
  <img src="./assets/depart.png">
      <img src="./assets/PP1.gif">
    <el-card style="width: auto;height: 700px">   
     <page3-vue></page3-vue>
    </el-card>
    <!-- <el-card style="width: auto;height: 500px;"> 

     <page4-vue></page4-vue>
    </el-card> -->
      <img src="./assets/depart.png">
          <img src="./assets/PP2.gif">
          <!-- <time-selector-vue></time-selector-vue> -->
          <table-page-vue></table-page-vue>
  </div> 

 
</template>

<script>
import page3Vue from './components/page3.vue'
import page4Vue from './components/page4.vue'
import TablePageVue from './components/TablePage.vue'
import timeSelectorVue from './components/timeSelector.vue'
import timeBarVue from './components/timeBar.vue'

export default {
    name: "App",
    components:{
      page3Vue,
      page4Vue,
      TablePageVue,
      timeSelectorVue,
      timeBarVue

    },

    
  
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.router-link-active {
  text-decoration: none;
  color: rgb(0, 0, 0);
   text-decoration: underline;
}
a{
  text-decoration: none;
  color: white;
}
</style>
 
