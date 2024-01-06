<template>
  <div style="width: auto;height:655px" id="main">

  </div>
</template>

<script>
const colors = ['#FFAE57', '#FF7853', '#EA5151', '#CC3F57', '#9A2555'];
const bgColor = '#2E2733';

const itemStyle = {
  star5: {
    color: colors[0]
  },
  star4: {
    color: colors[1]
  },
  star3: {
    color: colors[2]
  },
  star2: {
    color: colors[3]
  }
};

var AWTOpen={
  keyword1:"1",
  keyword2:"2",
  keyword3:"3",
  keyword4:"4",
  keyword5:"5",
  keyword6:"6"
}
var arr=[
    {
        "keyboard1": "Android + OpenCV",
        "keyboard2": "CanvasFrame",
        "keyboard3": "slash",
        "keyboard4": "2.5.22294",
        "keyboard5": "NullPointerException",
        "keyboard6": "auto-generated"
    },
    {
        "keyboard1": "images",
        "keyboard2": "Bump",
        "keyboard3": "Windows",
        "keyboard4": "ImgBot",
        "keyboard5": "Randomizer",
        "keyboard6": "NPE"
    },
    {
        "keyboard1": "Bump",
        "keyboard2": "javafx-controls",
        "keyboard3": "module",
        "keyboard4": "javafx-fxml",
        "keyboard5": "Optimize",
        "keyboard6": "javafx-maven-plugin"
    },
    {
        "keyboard1": "Eclipse",
        "keyboard2": "NPE",
        "keyboard3": "file",
        "keyboard4": "support",
        "keyboard5": "loop",
        "keyboard6": "opening"
    },
    {
        "keyboard1": "Error Report",
        "keyboard2": "Add",
        "keyboard3": "NPE",
        "keyboard4": "Plugin",
        "keyboard5": "file",
        "keyboard6": "lambda"
    },
    {
        "keyboard1": "Bump",
        "keyboard2": "3.4.16",
        "keyboard3": "ExecutionException",
        "keyboard4": "Update",
        "keyboard5": "TileNotFoundException",
        "keyboard6": "IOException"
    },
    {
        "keyboard1": "Bump",
        "keyboard2": "controls",
        "keyboard3": "fxml",
        "keyboard4": "graphics",
        "keyboard5": "version",
        "keyboard6": "base"
    },
    {
        "keyboard1": "Bump",
        "keyboard2": "Eclipse",
        "keyboard3": "disposed",
        "keyboard4": "Bugzilla",
        "keyboard5": "add",
        "keyboard6": "version"
    }
]
var keywords=[AWTOpen.keyword1,AWTOpen.keyword2,AWTOpen.keyword3,AWTOpen.keyword4,AWTOpen.keyword5,AWTOpen.keyword6,
                'keyword','keyword','keyword','keyword','keyword','keyword',
                'keyword','keyword','keyword','keyword','keyword','keyword',
                'keyword','keyword','keyword','keyword','keyword','keyword',
                'keyword','keyword','keyword','keyword','keyword','keyword',
                'keyword','keyword','keyword','keyword','keyword','keyword',
                'keyword','keyword','keyword','keyword','keyword','keyword',
                'keyword','keyword','keyword','keyword','keyword','keyword',
];

var data = [
  {
    name: 'Open\nIssue',
    itemStyle: {
      color: colors[1]
    },
    children: [
      {
        name: 'AWT',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[0]
              },
              {
                name: keywords[1]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[2]
              },
              {
                name: keywords[3]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[4]
              },
              {
                name: keywords[5]
              },
            ]
          },     
        ]
      },
      {
        name: 'Swing',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[6]
              },
              {
                name: keywords[7]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[8]
              },
              {
                name: keywords[9]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[10]
              },
              {
                name: keywords[11]
              },
            ]
          },     
        ]
      },
      {
        name: 'JavaFx',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[12]
              },
              {
                name: keywords[13]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[14]
              },
              {
                name: keywords[15]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[16]
              },
              {
                name: keywords[17]
              },
            ]
          },     
        ]
      },
      {
        name: 'SWT',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[18]
              },
              {
                name: keywords[19]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[20]
              },
              {
                name: keywords[21]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[22]
              },
              {
                name: keywords[23]
              },
            ]
          },     
        ]
      },
    ]
  },
  {
    name: 'Closed\nIssue',
    itemStyle: {
      color: colors[2]
    },
    children: [
      {
        name: 'AWT',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[24]
              },
              {
                name: keywords[25]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[26]
              },
              {
                name: keywords[27]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[28]
              },
              {
                name: keywords[29]
              },
            ]
          },     
        ]
      },
      {
        name: 'Swing',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[30]
              },
              {
                name: keywords[31]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[32]
              },
              {
                name: keywords[33]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[34]
              },
              {
                name: keywords[35]
              },
            ]
          },     
        ]
      },
      {
        name: 'JavaFx',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[36]
              },
              {
                name: keywords[37]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[38]
              },
              {
                name: keywords[39]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[40]
              },
              {
                name: keywords[41]
              },
            ]
          },     
        ]
      },
      {
        name: 'SWT',
        children: [
          {
            name: '5☆',
            children: [
              {
                name: keywords[42]
              },
              {
                name: keywords[43]
              },
            ]
          },
          {
            name: '4☆',
            children: [
              {
                name: keywords[44]
              },
              {
                name: keywords[45]
              },
            ]
          },
          {
            name: '3☆',
            children: [
              {
                name: keywords[46]
              },
              {
                name: keywords[47]
              },
            ]
          },     
        ]
      },
    ]
  }
];
    for(let v=0;v<2;v++){
      for(let u=0;u<4;u++){
          data[v].children[u].children[0].children[0].name=arr[v*4+u].keyboard1
          data[v].children[u].children[0].children[1].name=arr[v*4+u].keyboard2
          data[v].children[u].children[1].children[0].name=arr[v*4+u].keyboard3
          data[v].children[u].children[1].children[1].name=arr[v*4+u].keyboard4
          data[v].children[u].children[2].children[0].name=arr[v*4+u].keyboard5
          data[v].children[u].children[2].children[1].name=arr[v*4+u].keyboard6
      }
    }
for (let j = 0; j < data.length; ++j) {
  let level1 = data[j].children;
  for (let i = 0; i < level1.length; ++i) {
    let block = level1[i].children;
    let bookScore = [];
    let bookScoreId;
    for (let star = 0; star < block.length; ++star) {
      let style = (function (name) {
        switch (name) {
          case '5☆':
            bookScoreId = 0;
            return itemStyle.star5;
          case '4☆':
            bookScoreId = 1;
            return itemStyle.star4;
          case '3☆':
            bookScoreId = 2;
            return itemStyle.star3;
          case '2☆':
            bookScoreId = 3;
            return itemStyle.star2;
        }
      })(block[star].name);
      block[star].label = {
        color: style.color,
        downplay: {
          opacity: 0.5
        }
      };
      if (block[star].children) {
        style = {
          opacity: 1,
          color: style.color
        };
        block[star].children.forEach(function (book) {
          book.value = 1;
          book.itemStyle = style;
          book.label = {
            color: style.color
          };
          let value = 1;
          if (bookScoreId === 0 || bookScoreId === 3) {
            value = 5;
          }
          if (bookScore[bookScoreId]) {
            bookScore[bookScoreId].value += value;
          } else {
            bookScore[bookScoreId] = {
              color: colors[bookScoreId],
              value: value
            };
          }
        });
      }
    }
    level1[i].itemStyle = {
      color: data[j].itemStyle.color
    };
  }
}
import * as echarts from 'echarts'
import axios from 'axios';
  export default {
    name: "page3",
    components:{
    },
    data() {
      return {
        AWTOpen,
        keywords,
        data,
        arr
      }
    },
    created(){
    axios.get('http://localhost:8081/keyBoard')
    .then(res=>{
      arr=res.data

})
  

    
    },
    mounted() {

      this.echartsInit()
    },
    methods:{
      echartsInit() {

        echarts.init(document.getElementById('main')).setOption({
  backgroundColor: bgColor,
  color: colors,
  series: [
    {
      type: 'sunburst',
      center: ['50%', '48%'],
      data: data,
      sort: function (a, b) {
        if (a.depth === 1) {
          return b.getValue() - a.getValue();
        } else {
          return a.dataIndex - b.dataIndex;
        }
      },
      label: {
        rotate: 'radial',
        color: bgColor
      },
      itemStyle: {
        borderColor: bgColor,
        borderWidth: 2
      },
      levels: [
        {},
        {
          r0: 0,
          r: 40,
          label: {
            rotate: 0
          }
        },
        {
          r0: 40,
          r: 105
        },
        {
          r0: 115,
          r: 140,
          itemStyle: {
            shadowBlur: 2,
            shadowColor: colors[2],
            color: 'transparent'
          },
          label: {
            rotate: 'tangential',
            fontSize: 10,
            color: colors[0]
          }
        },
        {
          r0: 140,
          r: 145,
          itemStyle: {
            shadowBlur: 80,
            shadowColor: colors[0]
          },
          label: {
            position: 'outside',
            textShadowBlur: 5,
            textShadowColor: '#333'
          },
          downplay: {
            label: {
              opacity: 0.5
            }
          }
        }
      ]
    }
  ]
})
      }
    }
  }
</script>

<style scoped>

</style>
