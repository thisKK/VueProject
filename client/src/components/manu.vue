<template>
  <div>
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
    <body class="bg">
    <div style="color:#e3f2fd">
     <h3 class="section-heading mb-5 h1 mt-0 text-center ">MANU</h3>
    </div>
    <p></p>
    <div>
      <!-- Modal -->
      <div
        class="modal fade"
        id="basicExampleModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
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
    <div>
      <template>
        <mdb-container>
          <mdb-row>
            <mdb-card-group deck>
              <mdb-card type="button"
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

              <mdb-card>
                <mdb-view hover>
                  <a href="#!">
                    <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
                  </a>
                   <mdb-card-image 
                      src=""
                      alt="Card image cap"
                    ></mdb-card-image>
                </mdb-view>
                <mdb-card-body>
                  <mdb-card-text style="text-align: center;font-size:300%; color: #8ab4f8 ">ต้มยำกุ้ง</mdb-card-text>
                  <mdb-card-text style="text-align: center;font-size:120%">ประเภท:อาหาร</mdb-card-text>
                  <mdb-card-text style="text-align: center;font-size:120%">เทคนิคการปรุง:ต้ม</mdb-card-text>
                  <mdb-card-text style="text-align: center;font-size:50%">คำอธิบาย</mdb-card-text>
                </mdb-card-body>
              </mdb-card>
              <mdb-card>

                <mdb-view hover>
                  <a href="#!">
                    <mdb-card-image
                      src="https://s359.kapook.com/config-desktop/edfa78cb-51dc-4631-a133-4d79d69f9f5a.jpg"
                      alt="Card image cap"
                    ></mdb-card-image>
                    <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
                  </a>
                </mdb-view>
                 <mdb-card-body>
                  <mdb-card-text style="text-align: center;font-size:300%; color: #8ab4f8 ">กุ้งย่าง</mdb-card-text>
                  <mdb-card-text style="text-align: center;font-size:120%">ประเภท:อาหาร</mdb-card-text>
                  <mdb-card-text style="text-align: center;font-size:120%">เทคนิคการปรุง:นิ่ง</mdb-card-text>
                  <mdb-card-text style="text-align: center;font-size:50%">คำอธิบาย 
                  เป็นอาหารประเภทนิ่ง ซึ่งเป็นที่นิยมรับประทานไปทุกภาคทั่วโลก เป็นอาหารที่รับประทานกับน้ำจิ้มซีฟู๊ดรสเด็ดและ มีรสเปรี้ยวและเผ็ดเป็นหลักผสมเค็มและหวานเล็กน้อย</mdb-card-text>
                </mdb-card-body>
              </mdb-card>
            </mdb-card-group>
          </mdb-row>
        </mdb-container>
      </template>
    </div>
    </body>
  </div>
</template>

<script>
import axios from 'axios';
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
        let i = 0;
        let menuDe = [];
        
        this.design.menuDesign.forEach((designM)=>{
          menuDe.push(designM.id);
          console.log("push "+ designM.id);
        });

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
          getMenuDesign();
          currentObj.output = response.data;
        })
        .catch(e => {
           alert("เกิดข้อผิดพลาด "+error);
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
mdb-card-text {
  text-align: center;
}
text{
  text-align: center;
}
div.mask.flex-center.rgba-white-slight.ripple-parent {
  width: 360px!important;
  height: 270px!important;
  object-fit: cover !important;
}
body, html {
  height: 100%;
}
.bg {
  /* The image used */
background-image: url("https://www.bagri-restaurant.bg/wp-content/uploads/2014/05/header1.jpg");
  /* Half height */
  height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}
</style>
