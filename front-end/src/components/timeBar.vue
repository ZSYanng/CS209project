<template>
<div>


    <div>

<el-button style="background-color:tomato;color:white" @click="clicked">    {{ this.years +' (click to run)'}}
</el-button>

    </div>
  <div style="width: auto;height: 450px" id="main2">
    
  </div>
  </div>
</template>

<script>
import axios from 'axios';
import * as echarts from 'echarts';
var data = [0, 0,0,0];
var count=0;
var years="";
var stops=true;
var arr=[
  {
    'year':'2015 and before',
    'numAWT':100,
    'numSwing':99,
    'numJavaFx':98,
    'numSWT':97
  },
    {
    'year':'2016',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
      {
    'year':'2017',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
      {
    'year':'2018',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
      {
    'year':'2019',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
      {
    'year':'2020',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
      {
    'year':'2021',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
      {
    'year':'2022',
    'numAWT':10,
    'numSwing':10,
    'numJavaFx':10,
    'numSWT':10
  },
]
export default {
    name: "timeBar",
    data() {
      return {
          data,
          years,
          arr,
          stops

          
      }
    },
    created(){
      axios.get('http://localhost:8081/timeChange')
      .then(res=>{
          arr=res.data
          
      })


    },
    mounted() {
      this.echartsInit()
        //  setTimeout(() => {
        //     this.run();
        //  }, 0); 
         setInterval(() => {
            this.run();
         }, 1500); 
      
    },
    methods:{
      clicked(){
        stops=false
      },
      echartsInit() {
        echarts.init(document.getElementById('main2')).setOption({
  xAxis: {
    max: 'dataMax'
  },
  yAxis: {
    type: 'category',
    data: ['AWT', 'Swing', 'JavaFx', 'SWT'],
    inverse: true,
    animationDuration: 200,
    animationDurationUpdate: 300,
    max: 3 // only the largest 3 bars will be displayed
  },
  series: [
    {
      realtimeSort: true,
      name: 'IssueNmuber',
      type: 'bar',
      data: data,
      label: {
        show: true,
        position: 'right',
        valueAnimation: true
      }
    }
  ],
  legend: {
    show: true
  },
  animationDuration: 0,
  animationDurationUpdate: 1500,
  animationEasing: 'linear',
  animationEasingUpdate: 'linear'
})
      },
 run() {
if(!stops){
     if(count<7){
     count+=1;
        data[0]+=arr[count].numAWT
        data[1]+=arr[count].numSwing
        data[2]+=arr[count].numJavaFx
        data[3]+=arr[count].numSWT
        this.years=arr[count].year
   echarts.init(document.getElementById('main2')).setOption({
    series: [
      {
        type: 'bar',
        data
      }
    ]
  });
   } 
  }


}


    }

  }





</script>