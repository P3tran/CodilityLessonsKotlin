package leetcode.tree

class PreorderTraversal {
    companion object {

        data class TreeNode(var value: Int, var left: TreeNode?, var right: TreeNode?)

        @JvmStatic
        fun main(args: Array<String>) {
            val result = preorderTraversal(TreeNode(100, null, null))
            println("result :  $result")

        }

        fun preorderTraversal(root: TreeNode?): List<Int> {
            val result = mutableListOf<Int>()

            traversePreorder(root, result)
            return result
        }

        fun traversePreorder(node: TreeNode?, result: MutableList<Int>) {
            if (node == null)
                return

            result.add(node.value)

            traversePreorder(node.left, result)

            traversePreorder(node.right, result)
        }

        fun inorderTraversal(root: TreeNode): List<Int> {
            val result = mutableListOf<Int>()

            traverseInOrder(root, result)

            return result
        }

        private fun traverseInOrder(node: TreeNode?, result: MutableList<Int>) {
            if (node == null)
                return

            traverseInOrder(node.left, result)

            result.add(node.value)

            traverseInOrder(node.right, result)

        }

    }
}