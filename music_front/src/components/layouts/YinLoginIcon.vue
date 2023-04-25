<!--登录注册背景Icon（调用YinIcon,改变大小）-->
<template>
  <div class="login-Icon">
    <yin-icon :icon="icon"></yin-icon>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import YinIcon from "./YinIcon.vue";
import { Icon } from "@/enums";

export default defineComponent({
  components: {
    YinIcon,
  },
  data() {
    return {
      icon: Icon.ERJI,
    };
  },
});
</script>

<style lang="scss" scoped>
@import "@/assets/css/var.scss";
@import "@/assets/css/global.scss";

.login-Icon {
  background-color: $color-blue-light;
  height: calc(100vh - $header-height - $footer-height);
  min-width: 50vw;
  overflow: hidden;
  @include layout(center, center);
  .icon {
    @include icon(36rem, $color-blue-dark);
    transform: rotate(-30deg);
  }
}

@media screen and (min-width: $sm) {
  .login-Icon {
    width: 50vw;
  }
}

@media screen and (max-width: $sm) {
  .login-Icon {
    width: 100vw;
  }
}
</style>
