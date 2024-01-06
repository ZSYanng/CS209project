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
            title: {
            text: 'Number of repos on GitHub with java web-design topic',
            subtext: 'With keyword in title, topic, descrpition, readme'
            },
          xAxis: {
            type: 'category',
            data: ['Swing','AWT',  'JavaFx', 'SWT']
          },
          yAxis: {
            type: 'value'
          },
          series: [{
            data: [34117, 3043, 42309, 1493],
            type: 'bar',
            showBackground: true,
            backgroundStyle: {
              color: 'rgba(220, 220, 220, 0.8)'
            }
          }]
        })
      }
    }
  }
</script>

<style scoped>

</style>
