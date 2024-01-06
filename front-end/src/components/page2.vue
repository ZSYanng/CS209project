<template>
  <div style="width: auto;height: 400px" id="main">
  </div>
</template>

<script>
import * as echarts from 'echarts'
  export default {
    name: "page2",
    data() {
      return {}
    },
    mounted() {
      this.echartsInit()
    },
    methods:{
      echartsInit() {
        echarts.init(document.getElementById('main')).setOption({
          title: {
    text: 'Number of issues on GitHub with java web-design topic',
    subtext: '',
    left: 'center'
  },
  tooltip: {
    trigger: 'item'
  },
  legend: {
    orient: 'vertical',
    left: 'left'
  },
  series: [
    {
      name: 'Graph2',
      type: 'pie',
      radius: '50%',
      data: [
        { value: 145208, name: 'AWT' },
        { value: 116196, name: 'Swing' },
        { value: 29071, name: 'JavaFx' },
        { value: 16483, name: 'SWT' }
      ],
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      }
    }
  ]
        })
      }
    }
  }
</script>

<style scoped>

</style>
