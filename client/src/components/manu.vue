<template>
  <div class="bg">
    <mdb-navbar color="secondary-color-dark" dark>
      <mdb-navbar-brand href="https://mdbootstrap.com/">
        ShopManagement
      </mdb-navbar-brand>
      <mdb-navbar-toggler>
        <mdb-navbar-nav>
          <mdb-nav-item href="#" active>หน้าแรก</mdb-nav-item>
          <mdb-nav-item href="#">ออกแบบเมนู</mdb-nav-item>
          <mdb-nav-item href="#">จัดการสินค้า</mdb-nav-item>
          <mdb-nav-item href="#">จัดการออร์เดอร์</mdb-nav-item>
          <mdb-nav-item href="#">จัดการโต๊ะ</mdb-nav-item>
          <mdb-nav-item href="#">ชำระเงิน</mdb-nav-item>
          <mdb-dropdown tag="li" class="nav-item">
            <mdb-dropdown-toggle tag="a" navLink color="secondary-color-dark" slot="toggle" waves-fixed>ผู้ดูแลระบบ</mdb-dropdown-toggle>
            <mdb-dropdown-menu>
              <mdb-dropdown-item>จัดการพนักงาน</mdb-dropdown-item>
              <mdb-dropdown-item>จัดการระบบรีวิว</mdb-dropdown-item>
            </mdb-dropdown-menu>
          </mdb-dropdown>
        </mdb-navbar-nav>
      </mdb-navbar-toggler>
    </mdb-navbar>
    <div style="color:#e3f2fd">
     <h3 class="section-heading mb-5 h1 mt-0 text-center ">MANU</h3>
    </div>
    <p></p>
    <div>
      <!-- Modal -->
      <!-- <div
        class="modal fade"
        id="basicExampleModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      > -->
      <div
        class="modal fade"
        id="basicExampleModal"
        :show="openForm" @close="openForm = false"
        ref="my-modal"
      >
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">ออกแบบเมนู</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button> 
            </div>
            <div class="modal-body"><div class="modal-content">

            <!--Header-->
            <div class="modal-header info-color white-text">
            </div>
            <!--Body-->
            <div class="modal-body">

              <label for="defaultFormNameModalEx">รายการอาหาร</label>
              <select class="browser-default custom-select" v-model="design.menuList">
                 <option disabled value="">เลือกรายการอาหาร</option>
                <option v-for="menu in menuList" :key="menu.id" :value="menu.id">{{menu.name}}</option>
              </select>
              <br>

              <label for="defaultFormNameModalEx">รูปภาพ</label>
              <select class="browser-default custom-select" v-model="design.foodImage" >
                <option disabled value="">เลือกชื่อรูปภาพ</option>
                <option v-for="image in foodImage" :key="image.id" :value="image.id">{{image.nameImage}}</option>
              </select>
              <br>

              <!-- Default input techinque -->
              <label for="defaultFormEmailModalEx">เทคนิคการปรุง</label>
              <select class="browser-default custom-select" v-model="design.foodTechinque">
                 <option disabled value="">เลือกเทคนิคการปรุง</option>
                <option v-for="techinque in foodTechinque" :key="techinque.id" :value="techinque.id">{{techinque.nameTechinques}}</option>
              </select>
              <br>

              <!-- Default textarea message -->

               <mdb-input
                  type="textarea"
                  outline
                  :rows="4"
                  v-model="design.desciption" 
                  label="รายละเอียดเพิ่มเติม"
                />
            </div>
          </div>
          </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
               <mdb-btn outline="purple" icon="paper-plane" @click="saveCreateMenu($event)">Save</mdb-btn>
               
            </div>
          </div>
        </div>
      </div>
    </div>
        <div class="mycontainer">
              <div class="d-flex flex-wrap align-content-around">
              <mdb-card class="mycard" type="button"
                        data-toggle="modal"
                        data-target="#basicExampleModal">
                <mdb-view hover>
                  <a href="#!">
                    <mdb-card-image 
                      src="https://img.lovepik.com/element/40089/7450.png_860.png"
                      alt="Card image cap"
                    ></mdb-card-image>
                    <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
                  </a>
                </mdb-view>
                <mdb-card-body>
                  <mdb-card-text style="text-align: center;font-size:300% ; color: #00e676">เพิ่มเมนู</mdb-card-text>
                </mdb-card-body>
              </mdb-card>

              
                <mdb-card class="mycard" v-for="menu in menuDesign" :key="menu.id" :value="menu.id">
                  <mdb-view hover>
                    <a href="#!">
                      <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
                    </a>
                    <mdb-card-image 
                        v-bind:src= "menu.foodImage.urlImage"
                        alt="Card image cap"
                      ></mdb-card-image>
                  </mdb-view>
                  <mdb-card-body >
                    <mdb-card-text style="text-align: center;font-size:300%; color: #8ab4f8 ">{{menu.menuList.name}}</mdb-card-text>
                    <mdb-card-text style="text-align: center;font-size:120%">เทคนิคการปรุง:{{menu.foodTechinque.nameTechinques}}</mdb-card-text>
                    <mdb-card-text style="text-align: center;font-size:50%">คำอธิบาย {{menu.desciption}}</mdb-card-text>
                  </mdb-card-body>
                </mdb-card>
              </div>
        </div >
  </div>
</template>

<script>
import axios from 'axios';
axios.create({
  baseURL: "http://localhost:9000/",
  headers: {
    'Access-Control-Allow-Origin': '*',
    "Content-type": "application/json",
  }
});
import {
  mdbNavbar,
  mdbNavbarBrand,
  mdbNavbarToggler,
  mdbNavbarNav,
  mdbNavItem,
  mdbDropdown,
  mdbDropdownMenu,
  mdbDropdownToggle,
  mdbInput,
  mdbDropdownItem
} from "mdbvue";
import {
  mdbContainer,
  mdbRow,
  mdbCol,
  mdbCard,
  mdbCardImage,
  mdbCardHeader,
  mdbCardBody,
  mdbCardTitle,
  mdbCardText,
  mdbCardFooter,
  mdbCardUp,
  mdbCardAvatar,
  mdbCardGroup,
  mdbBtn,
  mdbView,
  mdbMask,
  mdbIcon,
} from "mdbvue";

export default {
  name: "menuDesign",
  components: {
    mdbNavbar,
    mdbNavbarBrand,
    mdbNavbarToggler, 
    mdbNavbarNav,
    mdbNavItem,
    mdbDropdown,
    mdbDropdownMenu,
    mdbDropdownToggle,
    mdbDropdownItem,
    mdbInput,
    mdbContainer,
    mdbRow,
    mdbCol,
    mdbCard,
    mdbCardImage,
    mdbCardHeader,
    mdbCardBody,
    mdbCardTitle,
    mdbCardText,
    mdbCardFooter,
    mdbCardUp,
    mdbCardAvatar,
    mdbCardGroup,
    mdbBtn,
    mdbView,
    mdbMask,
    mdbIcon
  },
  data() {
    return {
      openForm: false,
      menuList:[],
      foodImage:[],
      foodTechinque:[],
      menuDesign:[],
      desciption:"",

      design:{
        menuList:"",
        foodImage:"",
        foodTechinque:"",
        desciption: "",
        menuDesign:[]
      }
    }
  },
  methods:{
    getFoodImage(){
      axios.get("http://localhost:9000/getFoodImage").then(
        response =>{
          this.foodImage = response.data
        }
      ).catch(err => {console.log(err)});
    },
    getMenuList(){
      axios.get("http://localhost:9000/getMenuList").then(
        response =>{
          this.menuList = response.data
        }
      ).catch(err => {console.log(err)});
    },
  getFoodTechinque(){
      axios.get("http://localhost:9000/getFoodTechinque").then(
        response =>{
          this.foodTechinque = response.data
        }
      ).catch(err => {console.log(err)});
    },

    getMenuDesign(){
      axios.get("http://localhost:9000/getMenuDesign").then(
        response =>{
          this.menuDesign = response.data
        }
      ).catch(err => {console.log(err)});
    },

  
  saveCreateMenu(){
      let currentObj = this;
      axios.post(
          "http://localhost:9000/createMenuDesign/" +
            this.design.menuList +
            "/" +
            this.design.foodImage +
            "/" +
            this.design.foodTechinque +
            "/" +
            this.design.desciption
        )
        .then(response => {
          alert("ออกแบบเมนูสำเร็จ")
          currentObj.openForm = false;
          currentObj.getMenuDesign();
        })
        .catch(e => {
           alert("เกิดข้อผิดพลาด "+e);
           currentObj.output = error;
        });
      this.submitted = true;
    }
  },

  mounted(){
    this.getFoodImage();
    this.getMenuList();
    this.getFoodTechinque();
    this.getMenuDesign();
  }
};
</script>
<style>
.mycontainer {
  margin-left: 30px!important;
  margin-right: 30px!important;
}
mdb-card-text {
  text-align: center;
}
text{
  text-align: center;
}
body, html {
  height: 100%;
}
.bg {
  /* The image used */
background-image: url("https://www.bagri-restaurant.bg/wp-content/uploads/2014/05/header1.jpg");
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  width: 100%;
  height: auto;
}
.mycard {
  width: 300px!important;
  margin:2ch;
}
</style>
