https://camo.githubusercontent.com/42467552c087fb92a279741a2f72fdaa0bbb3427e07c828ff5ff8d5f0bd259af/68747470733a2f2f702e697069632e7669702f6d70346b33722e676966



# DFS of a tree is more like:

function dfs(root) {
	if (condition）{
		<!-- return result or exit search journey -->
	}
	for (const child of root.children) {
        dfs(child)
	}
}

function dfs(root) {
	if (condition）{
		<!-- return result or exit search journey -->
	}
    dfs(root.left)
    dfs(root.right)
}
