<template>
  <div id="app">
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
    <menuDesign/>
  </div>
</template>

<script>
import menuDesign from '@/components/menuDesign'
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbvue/build/css/mdb.css';
import '../public/style.css';
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
  name: 'app',
  components: {
    menuDesign,
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
}
}
</script>

<style>

</style>
