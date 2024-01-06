<template>
<div>
 <div>
	      <input type="text" @keyup.enter="search" @input="search($event)"/>
	    </div>
<el-date-picker v-model="valuedate" type="daterange" 
     unlink-panels range-separator="to"
      start-placeholder="Start at" end-placeholder="End at" 
      :picker-options="pickerOptions" format="yyyy / MM/ dd"
      value-format="yyyy-MM-dd">
</el-date-picker>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </div>
</template>

<script>
import axios from 'axios';
import request from '@/utils/request';

   export default {
    data() {
      return {
        valuedate:'',
        pickerOptions:'',
         pickdata: {
                    topic:'',
                    startTime: '',
                    endTime: '',
                },
      };
    },
    methods: {
      onSubmit() {
        if (this.valuedate.length == '0') {
                    this.$alert('Please choose date！', 'Warn', {
                        confirmButtonText: 'sure',
                        type: 'waring',
                    });
                } else {
                    this.pickdata.startTime = this.valuedate[0]
                    this.pickdata.endTime = this.valuedate[1]
                    var obj={
                      "created_at":this.pickdata.startTime,
                      "updated_at":this.pickdata.endTime,
                      "topic":this.pickdata.topic
                    }
                    var myJson=JSON.stringify(obj);
                    axios.post("http://localhost:8081/limitTime",myJson)
                    alert("start at:"+this.pickdata.startTime+
                    "\nend at:"+this.pickdata.endTime+"\ntopic："+this.pickdata.topic)
                }
     },
     	        search(event){
	          this.pickdata.topic=event.currentTarget.value
	        }
    },
  }
</script>