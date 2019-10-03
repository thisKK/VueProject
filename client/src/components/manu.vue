<template>
  <div class="bg">
    <mdb-navbar color="secondary-color-dark" dark>
      <mdb-navbar-brand href="https://mdbootstrap.com/">ShopManagement</mdb-navbar-brand>
      <mdb-navbar-toggler>
        <mdb-navbar-nav>
          <mdb-nav-item href="#" active>หน้าแรก</mdb-nav-item>
          <mdb-nav-item href="#">ออกแบบเมนู</mdb-nav-item>
          <mdb-nav-item href="#">จัดการสินค้า</mdb-nav-item>
          <mdb-nav-item href="#">จัดการออร์เดอร์</mdb-nav-item>
          <mdb-nav-item href="#">จัดการโต๊ะ</mdb-nav-item>
          <mdb-nav-item href="#">ชำระเงิน</mdb-nav-item>
          <mdb-dropdown tag="li" class="nav-item">
            <mdb-dropdown-toggle
              tag="a"
              navLink
              color="secondary-color-dark"
              slot="toggle"
              waves-fixed
            >ผู้ดูแลระบบ</mdb-dropdown-toggle>
            <mdb-dropdown-menu>
              <mdb-dropdown-item>จัดการพนักงาน</mdb-dropdown-item>
              <mdb-dropdown-item>จัดการระบบรีวิว</mdb-dropdown-item>
            </mdb-dropdown-menu>
          </mdb-dropdown>
        </mdb-navbar-nav>
      </mdb-navbar-toggler>
    </mdb-navbar>
    <br />
    <br />
    <h3 class="title section-heading mb-5 h1 mt-0">MENU</h3>
    <div >
      <form  >
        <div
          class="modal fade"
          id="basicExampleModal"
          
        >
          <div class="modal-dialog" role="document" v-if="openForm == true" >
            <div class="modal-content">
              <div class="modal-header" >
                <h5 class="modal-title" id="exampleModalLabel">ออกแบบเมนู</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <div class="modal-content">
                  <!--Header-->
                  <div class="modal-header info-color white-text"></div>
                  <!--Body-->
                  <div class="modal-body">
                    <label for="defaultFormNameModalEx">รายการอาหาร</label>
                    <select 
                    class="browser-default custom-select" v-model="design.menu">
                      <option value="" disabled selected>เลือกรายการอาหาร</option>
                      <option v-for="menuList in menu" :key="menuList.id" :value="menuList.id">{{menuList.menuName}}</option>
                    </select>
                    <br />

                    <label for="defaultFormNameModalEx">รูปภาพ</label>
                    <div class="row">
                      <!-- Grid column -->
                      <div class="col">
                        <!-- Default input -->
                        <select class="browser-default custom-select" v-model="design.foodImage">
                          <option value="" disabled selected>เลือกชื่อรูปภาพ</option>
                          <option
                            v-for="image in foodImage"
                            :key="image.id"
                            :value="image.id"
                          >{{image.nameImage}}</option>
                        </select>
                      </div>
                      <div class="col">
                        <button @click="()=>onShowInsertURL(this)" class="btn btn-primary btn-sm">
                          <i class="fas fa-magic mr-1"></i> with URL
                        </button>
                      </div>
                    </div>

                    <div v-if="showInsertURL ==true">
                      <mdb-input
                        v-model="design.foodImageNameUrl"
                        type="textarea"
                        outline
                        :rows="1"
                        label="ชื่อรูปภาพ"
                      />

                      <mdb-input
                        v-model="design.foodImageUrl"
                        type="textarea"
                        outline
                        :rows="1"
                        label="URL รูปภาพ"
                      />
                    </div>

                    <!-- Default input techinque -->
                    <label for="defaultFormEmailModalEx">เทคนิคการปรุง</label>
                    <select class="browser-default custom-select" v-model="design.foodTechinque">
                      <option value="" disabled selected>เลือกเทคนิคการปรุง</option>
                      <option
                        v-for="techinque in foodTechinque"
                        :key="techinque.id"
                        :value="techinque.id"
                      >{{techinque.nameTechinques}}</option>
                    </select>
                    <br />
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
                <mdb-btn outline="purple" icon="paper-plane" @click="()=>onCreateSubmit(this)">Save</mdb-btn>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>

    <div class="mycontainer" >
      <div class="d-flex flex-wrap align-content-around" @click="()=>onOpenForm(this)">
        <mdb-card class="mycard" type="button" data-toggle="modal" data-target="#basicExampleModal" >
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
        <mdb-card class="mycard" v-for="menuList in menuDesign" :key="menuList.id" :value="menuList.id">
          <mdb-view hover>
            <a href="#!">
              <mdb-mask flex-center waves overlay="white-slight"></mdb-mask>
            </a>
            <div v-if="menuList.foodImage.urlImage != null" class="view overlay zoom">
              <mdb-card-image
                class="image-size"
                v-bind:src="menuList.foodImage.urlImage"
                alt="Card image cap"
              ></mdb-card-image>
            </div>
            <div v-else class="view overlay zoom">
              <mdb-card-image class="image-size" v-bind:src="url" alt="Card image cap"></mdb-card-image>
            </div>
          </mdb-view>
          <mdb-card-body>
            <mdb-card-text class="card-name">{{menuList.menu.menuName}}</mdb-card-text>
            <mdb-card-text
              class="card-techinque"
            >เทคนิคการปรุง:{{menuList.foodTechinque.nameTechinques}}</mdb-card-text>
            <mdb-card-text class="card-disciption">คำอธิบาย {{menuList.desciption}}</mdb-card-text>
            <mdb-card-text class="card-price">ราคา:{{menuList.menu.menuPrice}} บาท</mdb-card-text>
          </mdb-card-body>
        </mdb-card>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
const https = axios.create({
  baseURL: "http://localhost:9000/",
  heaers: {
    "Access-Control-Allow-Origin": "*",
    "Content-type": "application/json"
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
  mdbIcon
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
      showInsertURL: false,
      openForm: false,

      menu: [],
      foodImage: [],
      foodTechinque: [],
      menuDesign: [],
      desciption: "",
      url: "",

      design: {
        menu: "",
        foodImage: "",
        foodImageUrl: "",
        foodImageNameUrl: "",
        foodTechinque: "",
        desciption: "",
        menuDesign: []
      }
    };
  },
  updated() {
    //console.log(this);
  },

  methods: {
    onShowInsertURL(main) {
      //console.log(main);
      main.showInsertURL = !main.showInsertURL;
      main.design.foodImage = "";
    },
    onOpenForm(main) {
      //console.log(main);
      main.openForm = true;
      //console.log(main.openForm);
    },
    onCreateSubmit(main) {
      if (main.design.foodImage != "") {
        main.saveCreateMenu();
      } else if (
        main.design.foodImageUrl != "" &&
        main.design.foodImageNameUrl != ""
      ) {
        main.saveCreateMenuWithUrl();
      }
    },
    getFoodImage() {
      axios
        .get("http://localhost:9000/getFoodImage")
        .then(response => {
          this.foodImage = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getMenu() {
      axios
        .get("http://localhost:9000/getMenu")
        .then(response => {
          this.menu = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    getFoodTechinque() {
      axios
        .get("http://localhost:9000/getFoodTechinque")
        .then(response => {
          this.foodTechinque = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },

    getMenuDesign() {
      axios
        .get("http://localhost:9000/getMenuDesign")
        .then(response => {
          this.menuDesign = response.data;
        })
        .catch(e => {
          console.log(e);
        });
    },
    saveCreateMenuWithUrl() {
      let currentObj = this;
      axios({
        method: "post",
        url: "http://localhost:9000/createWithUrl",
        headers: { "Content-Type": "application/json" },
        data: {
          
          menuId: this.design.menu,

          foodTechinqueId: this.design.foodTechinque,

          desc: this.design.desciption,

          nameImage: this.design.foodImageNameUrl,

          urlImage: this.design.foodImageUrl
        }
      })
        .then(response => {
          alert("ออกแบบเมนูสำเร็จ");
          currentObj.getMenuDesign();
          currentObj.design={};
          currentObj.showInsertURL = false;
          currentObj.openForm= false;
        })
        .catch(e => {
          alert("เกิดข้อผิดพลาด " + e);
          currentObj.output = e;
          currentObj.design={};
          currentObj.showInsertURL = false;
          currentObj.openForm= false;
        });
    },

    saveCreateMenu() {
      let currentObj = this;
      axios
        .post(
          "http://localhost:9000/createMenuDesign/" +
            this.design.menu +
            "/" +
            this.design.foodImage +
            "/" +
            this.design.foodTechinque +
            "/" +
            this.design.desciption
        )
        .then(response => {
          alert("ออกแบบเมนูสำเร็จ");
          currentObj.getMenuDesign();
          currentObj.design={};
          currentObj.openForm= false;
        })
        .catch(e => {
          alert("เกิดข้อผิดพลาด " + e);
          currentObj.output = e;
          currentObj.design={};
          currentObj.showInsertURL = false;
          currentObj.openForm= false;
        });
    },
  },

  mounted() {
    this.getFoodImage();
    this.getMenu();
    this.getFoodTechinque();
    this.getMenuDesign();
  }
};
</script>
<style>
.title {
  color: #e3f2fd;
  text-align: center;
  font-size: 500% !important;
}
.mycontainer {
  margin-left: 30px !important;
  margin-right: 30px !important;
}
mdb-card-text {
  text-align: center;
}
text {
  text-align: center;
}
body,
html {
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
.card-name {
  text-align: center;
  font-size: 250% !important;
  color: #8ab4f8 !important;
}
.card-techinque {
  text-align: center;
  font-size: 120% !important;
}
.card-disciption {
  text-align: center;
  font-size: 50% !important;
}
.card-price {
  position: absolute;
  bottom: 8px;
  right: 16px;
  font-size: 18px;
}
.mycard {
  width: 300px !important;
  margin: 2ch;
}
.image-size {
  max-width: 120% !important;
  max-height: 100% !important;
}
</style> 
