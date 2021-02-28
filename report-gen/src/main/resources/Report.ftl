<template>
    <el-container>
        <el-header>

        </el-header>
        <el-main>
            <el-table
                    :data="tableData"
                    stripe
                    style="width: 100%"
                    height="100%">
                <#list reportColumns as reportColumn>
                    <el-table-column
                            prop="${reportColumn.prop}"
                            label="${reportColumn.label}"
                            <#if reportColumn.label?length gt 4>
                                :render-header="renderHeader"
                            </#if>
                            <#if reportColumn.label?contains("时间")>
                                min-width="160"
                            </#if>
                    >
                    </el-table-column>
                </#list>
                <el-table-column
                        fixed="right"
                        label="操作"
                        width="100">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-main>
        <el-footer>
            <Page></Page>
        </el-footer>
        <${reportDetail} :visible="isVisible" :currentRowData="currentRowData"/>
    </el-container>

</template>

<script>
    import ${reportDetail} from './${reportDetail}.vue'

    export default {
        components: {
            ${reportDetail}
        },

        method: {
            handleClick(row) {
                this.currentRowData = row
                this.isVisible = true;
            },
            renderHeader() {

            }
        },

        data() {
            return {
                tableData: [],
                isVisible: false,
                currentRowData: {},
            }
        }
    }
</script>
<style>

</style>