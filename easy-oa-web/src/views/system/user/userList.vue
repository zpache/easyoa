<template>
  <div class="app-container">
    <el-form :inline="true" :v-model="queryUser" class="form-inline" size="small">
      <el-form-item label="姓名">
        <el-input v-model="queryUser.name" placeholder="姓名"></el-input>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="queryUser.mobile" placeholder="手机号码"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="queryUser.status" placeholder="状态" clearable>
          <el-option label="在职" value="0"></el-option>
          <el-option label="离职" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" @click="onsubmit()" size="small">查询</el-button>
        <el-button type="primary" icon="el-icon-edit" @click="onCreate()" size="small">新增</el-button>
        <el-button type="default" @click="onClear()" size="small">重置</el-button>
      </el-form-item>
    </el-form>
    <el-table
    :data="list"
    stripe
    style="width: 100%">
    <el-table-column label="头像" width="80">
      <template slot-scope="scope">
        <el-avatar shape="square" size="small" :src="scope.row.avatar"></el-avatar>
      </template>
    </el-table-column>
    <el-table-column prop="name" label="姓名" width="120"></el-table-column>
    <el-table-column prop="loginName" label="用户名" width="150"></el-table-column>
    <el-table-column prop="depName" label="部门名称" width="120"></el-table-column>
    <el-table-column prop="roleName" label="角色" width="120"></el-table-column>
    <el-table-column prop="mobile" label="手机号码" ></el-table-column>
    <el-table-column prop="workNo" label="工号" width="120"></el-table-column>
    <el-table-column prop="status" label="状态" width="120">
      <template slot-scope="scope">
        <el-tag v-if="scope.row.status==0" type="success">在职</el-tag>
        <el-tag v-if="scope.row.status==1" type="info">离职</el-tag>
      </template>
    </el-table-column>
    <el-table-column fixed="right" label="操作" width="180">
      <template slot-scope="scope">
        <el-button @click="viewUser(scope.row)" type="text" size="small">查看</el-button>
        <el-button @click="modifyUser(scope.row)" type="text" size="small">修改</el-button>
        <el-button @click="deleteUser(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
    background
    layout="sizes,prev,pager,next,jumper,total,slot"
    :total="total"
    :page-count="pageCount"
    :page-sizes="pageSizes"
    @current-change="pageChange"
    @size-change="sizeChange"
  >
  </el-pagination>  

  <el-dialog :title="dialog.title" :visible.sync="dialog.show">
    <el-form :inline="true" model="modifyUser" v-if="dialog.formVisiable">
      <el-form-item label="姓名">
        <el-input v-model="modifyUser.name"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
    <el-button @click="dialog.show = false">取 消</el-button>
    <el-button type="primary" @click="saveUser">确 定</el-button>
  </div>
  </el-dialog>
  </div>
</template>

<script>
import { userList } from '@/api/system/user'

export default {
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'gray',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      queryUser: {
        name: null,
        mobile: null,
        status: null,
        pageNum: 1,
        pageSize: 10
      },
      modifyUser: {
        name: '',
        mobile: '',
        gender: '',
        loginName: '',
        depId: '',
        workNo: ''
      },
      list: null,
      total: 0,
      pageCount: 0,
      pageSizes: [10,20],
      listLoading: true,
      dialog: {
        mode: '',
        show: false,
        title: '',
        formVisiable: true
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      userList(this.queryUser).then(response => {
        this.list = response.data.records
        this.total = response.data.total
        this.pageCount = response.data.pages
        this.listLoading = false
      })
    },
    viewUser(row){
      console.log(row);
    },
    modifyUser(row){
      console.log(row);
    },
    deleteUser(row){
      console.log(row);
    },
    onsubmit(){
      this.fetchData()
    },
    onClear(){
      this.queryUser = {
        name: null,
        mobile: null,
        status: null,
        pageNum: 1,
        pageSize: 10
      }
    },
    onCreate(){
      this.dialog.mode = 'add'
      this.dialog.title = '新增用户'
      this.dialog.show = true
    },
    pageChange(page){
      this.queryUser.pageNum = page
      this.fetchData()
    },
    sizeChange(pageSize){
      console.log(pageSize)
      this.queryUser.pageSize = pageSize
      this.fetchData()
    },
    saveUser(){

    }
  }
}
</script>
