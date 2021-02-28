<template>

    <el-dialog
            title="详情"
            :visible.sync="isVisible"
            :currentRowdata="currentRowData"
            width="30%"
            :before-close="handleClose">
        <el-form :model="currentRowData" disabled>
            <#list reportColumns as reportColumn>
                <el-form-item label="${reportColumn.label}">
                    <el-input v-model="${reportColumn.prop}"></el-input>
                </el-form-item>
            </#list>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="onClick">取 消</el-button>
        </div>
    </el-dialog>
</template>
<script>
    export default {
        props: {
            currentRowData: {
                type: [],
                required: true
            },
            isVisible: {
                type: Boolean,
                required: true,
                default: false
            }
        },

        method: {
            handleClose() {
                this.$emit("update:isVisible", false)
            },
            onClick() {
                this.$emit("update:isVisible", false)
            }
        }
    }
</script>