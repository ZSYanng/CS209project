<template>
  <div style="width: auto;height: 400px" id="main">
  </div>
</template>

<script>
import * as echarts from 'echarts'
  export default {
    name: "page1",
    data() {
      return {}
    },
    mounted() {
      this.echartsInit()
    },
    methods:{
      echartsInit() {
        echarts.init(document.getElementById('main')).setOption({
  legend: {},
  tooltip: {},
  dataset: {

    source: [
      ['topic', 'Swing', 'AWT', 'JavaFx', 'SWT'],
      ['Forks', 18884, 2355, 45359, 2113],
      ['Watchers', 39608, 6014, 132388, 4664],
    ]
  },
  xAxis: [
    { type: 'category', gridIndex: 0 },
  ],
  yAxis: [{ gridIndex: 0 }, ],
  grid: [{ bottom: '20%' }, ],
  series: [
    // These series are in the first grid.
    { type: 'bar', seriesLayoutBy: 'row' },
    { type: 'bar', seriesLayoutBy: 'row' },
  ]
})
      }
    }
  }
</script>

<style scoped>

</style>
