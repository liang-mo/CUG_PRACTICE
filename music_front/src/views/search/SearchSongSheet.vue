<template>
  <div class="search-song-sheet">
    <show-list :playList="showList" path="song-sheet-detail"></show-list>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, computed, watch, onMounted, getCurrentInstance } from "vue";
import { useStore } from "vuex";
import ShowList from "@/components/ShowList.vue";
import { HttpManager } from "@/api";

export default defineComponent({
  components: {
    ShowList: ShowList,
  },
  setup() {
    const { proxy } = getCurrentInstance();
    const store = useStore();

    const showList = ref([]);
    const searchWord = computed(() => store.getters.searchWord);
    watch(searchWord, (value) => {
      getSearchList(value);
    });

    async function getSearchList(value) {
      if (!value) return;
      const result = (await HttpManager.getSongListOfLikeTitle(value)) as ResponseBody;
      if (!result.data.length) {
        (proxy as any).$message({
          message: "暂无该歌曲内容",
          type: "warning",
        });
      } else {
        showList.value = result.data;
      }
    }

    onMounted(() => {
      getSearchList(proxy.$route.query.keywords);
    });

    return {
      showList: showList,
    };
  },
});
</script>
