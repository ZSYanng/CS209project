<template>
    <div>
        <el-radio-group v-model="sort" style="height: 70px" @change="ischanged">
      <el-radio-button label="AWT"></el-radio-button>
      <el-radio-button label="Swing"></el-radio-button>
      <el-radio-button label="JavaFx"></el-radio-button>
      <el-radio-button label="SWT"></el-radio-button>
    </el-radio-group>
         <el-form :inline="true"  class="demo-form-inline">
               <el-form-item >
         <el-tag size="small">{{'IssueNmuber:' + this.tableData.length}}</el-tag>
      </el-form-item>
  <el-form-item label="Date Range">
    <el-date-picker v-model="valuedate" type="daterange" 
     unlink-panels range-separator="to"
      start-placeholder="Start at" end-placeholder="End at" 
      :picker-options="pickerOptions" format="yyyy / MM/ dd"
      value-format="yyyy-MM-dd">
</el-date-picker>
  </el-form-item>
  <el-form-item label="Topic">
 <div>
   <el-input v-model="input" placeholder="Please enter topic"></el-input>
	</div>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">Search</el-button>
  </el-form-item>
    <el-form-item>
        <div style="text-align:end">        <el-button type="primary"  @click="exportExcelSelect">Export</el-button>
</div>  </el-form-item>
</el-form>
        <!--原始表格-->
        <el-table

            :data="tableData"
            stripe
            @selection-change="handleSelectionChange"
            style="width: 100%"
            height="600"
        >
            <el-table-column
               type="selection"
            >
            </el-table-column>
            <el-table-column
                sortable
                prop="createdAt"
                label="CreatedTime"
                width="200">
            </el-table-column>
    <el-table-column
      sortable
      prop="updatedAt"
      label="UpdatedTime"
      width="200">
      
    </el-table-column>
<el-table-column label="Title" width="250" show-overflow-tooltip>
   <template slot-scope="scope">
           <el-button @click="handle(scope.row.htmlUrl)" type="text" size="small">{{scope.row.topic}}</el-button> 
         </template> 

</el-table-column>
<el-table-column
      prop="state"
      label="State"
      width="100"
      :filters="[{ text: 'CLOSED', value: 'closed' }, { text: 'OPEN', value: 'open' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.state === 'open' ? 'warning' : 'success'"
          disable-transitions>{{scope.row.state==='open' ? 'OPEN' : 'CLOSED'}}</el-tag>
      </template>
    </el-table-column>
  
    <el-table-column
      prop="content"
      label="Body"
      width="auto"
       show-overflow-tooltip>
    </el-table-column>
        </el-table>
        <!--预览弹窗表格-->
        <el-dialog title="Preview" width="70%" :visible.sync="selectWindow">
            <el-table :data="selectData" id="selectTable" height="380px">

    <el-table-column
      sortable
      prop="createdAt"
      label="CreatedTime"
      width="200">
      
    </el-table-column>
    <el-table-column
      sortable
      prop="updatedAt"
      label="UpdatedTime"
      width="200">
      
    </el-table-column>
<el-table-column label="OrignalIssue" width="120" show-overflow-tooltip>
   <template slot-scope="scope">
           <el-button @click="handle(scope.row.htmlUrl)" type="text" size="small">{{scope.row.htmlUrl}}</el-button> 
         </template> 

</el-table-column>
<el-table-column
      prop="state"
      label="State"
      width="100"
      :filters="[{ text: 'CLOSED', value: 'closed' }, { text: 'OPEN', value: 'open' }]"
      :filter-method="filterTag"
      filter-placement="bottom-end">
      <template slot-scope="scope">
        <el-tag
          :type="scope.row.state === 'open' ? 'warning' : 'success'"
          disable-transitions>{{scope.row.state==='open' ? 'OPEN' : 'CLOSED'}}</el-tag>
      </template>
    </el-table-column>
    <el-table-column
      prop="topic"
      label="Title"
      width="300">
    </el-table-column>
    <el-table-column
      prop="content"
      label="Body"
      width="auto"
       show-overflow-tooltip>
    </el-table-column>
            </el-table>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="exportExcel">Sure</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import axios from 'axios'
    import htmlToExcel from '@/utils/htmlToExcel'
    export default {
        name: "ExcelPage",
        data(){
            return{
              sort:'AWT',
              valuedate:'',
              input:'',
        pickerOptions:'',
         pickdata: {
                    topic:'',
                    startTime: '',
                    endTime: ''
                },
                //表格数据
                tableData: [{
          id: '1225038668',
          createdAt: '2022-05-04T07:59:41Z',
          updatedAt: '2022-05-10T04:37:54Z',
          htmlUrl: 'https://github.com/mdsecresearch/BurpSuiteSharpener/pull/73',
          topic: 'Update SWT_AWT.java',
          state:'open',
          content: 'null',

        }],
                //表格中选中的数据
                selectData:[],
                selectWindow:false,
            }
        },
        created() {
          axios.get('http://localhost:8081/AWTIssue/concrete')
          .then(res=>{
            // alert("111");
            // console.log(res.data);
            this.tableData = res.data;
            //将api中College数据读入到此文件中的College数据中
    })
    .catch(error=>{
      alert("error");
    })
    },
        methods:{
          ischanged(){
          axios.get('http://localhost:8081/'+this.sort+'Issue/concrete')
          .then(res=>{
            // alert("111");
            // console.log(res.data);
            this.tableData = res.data;
            //将api中College数据读入到此文件中的College数据中
    })
    
    .catch(error=>{
      alert("error");
    })
          },
                onSubmit() {

                if (this.valuedate.length == '0') {
                    this.$alert('Please choose date！', 'Warn', {
                        confirmButtonText: 'sure',
                        type: 'waring',
                    });
                } else {
                    this.loading=true
                    this.pickdata.startTime = this.valuedate[0]
                    this.pickdata.endTime = this.valuedate[1]
                    this.pickdata.topic=this.input;
                    let params= new URLSearchParams();
                    params.append("sort",this.sort);
                    params.append("created_at",this.pickdata.startTime);
                    params.append("updated_at",this.pickdata.endTime);
                    params.append("topic",this.pickdata.topic);
                    axios.post("http://localhost:8081/limitTime",params)
                    .then(res=>{
            // alert(res.data);
            // console.log(res.data);
            this.tableData =res.data;
    })
    this.loading=false
                    // alert("start at:"+this.pickdata.startTime+
                    // "\nend at:"+this.pickdata.endTime+"\ntopic："+this.input)          
                }
     },
     	        search(event){
	        },
            //导出
          formatter(row, column) {
          return row.address;
          },
          filterTag(value, row) {
            return row.state === value;
          },
          handle(htmlUrl) {
            window.open(htmlUrl, '_blank')
          },
          exportExcel() {
              htmlToExcel.getExcel('#selectTable')
          },
          //显示预览弹窗
          exportExcelSelect(){
              if (this.selectData.length < 1){
                  this.$message.error('Please choose at least one row！');
                  return false;
              }
              this.selectWindow = true;
          },
          //选中数据
          handleSelectionChange(val) {
              this.selectData = val;
          }
            
        }
    }
</script>

<style scoped>
</style>
