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
          color:['#4472C5','#96D8DE'],
            tooltip: {
    trigger: 'axis',
    axisPointer: {
      // Use axis to trigger tooltip
      type: 'shadow' // 'shadow' as default; can also be 'line' or 'shadow'
    }
  },
  legend: {},
  grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
  xAxis: {
    type: 'value'
  },
  yAxis: {
    type: 'category',
    data: ['AWT', 'Swing', 'JavaFx', 'SWT',]
  },
  series: [
    {
      name: 'OpenIssue',
      type: 'bar',
      stack: 'total',
      label: {
        show: true
      },
      emphasis: {
        focus: 'series'
      },
      data: [11123, 12327, 5778, 4415],

    },
    {
      name: 'ClosedIssue',
      type: 'bar',
      stack: 'total',
      label: {
        show: true
      },
      emphasis: {
        focus: 'series'
      },
      data: [134085, 103869,23293,12068 ],
            itemStyle: {
                        normal: {
                            color:function(){return '#96D8DE';}
                        },
                    },
    }
  ]
        })
      }
    }
  }
</script>

<style scoped>

</style>
