<template>
  <div class="app-container">
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
    page-sizes="[10,20]"
  >
  </el-pagination>  
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
      list: null,
      total: 0,
      pageCount: 0,
      listLoading: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      userList({'pageNum':1,'pageSize':10}).then(response => {
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
    }
  }
}
</script>
