<!--错误信息显示页面-->
<template>
  <div class="error-page">
    <div class="error-code">Not Found</div>
  </div>
</template>

<style scoped>
.error-page {
  display: flex;
  justify-content: center;
  align-items: stretch;
  flex-direction: row;
  flex-wrap: nowrap;
  width: 100%;
  height: 100%;
  padding: 11rem 0;
  box-sizing: border-box;
}

.error-code {
  font-size: 250px;
  font-weight: bolder;
  color: #000000;
}
</style>