object ApplicationVersion {

    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionBuild = 0

    fun computeVersionCode(): Int {
        // Major + Minor + Patch + build number
        return (versionMajor * 100_000_000) +
                (versionMinor * 100_000) +
                (versionPatch * 100) +
                Integer.valueOf(versionBuild)
    }

    fun computeVersionName(): String {
        // Major + Minor + Patch + Build
        return "$versionMajor.$versionMinor.$versionPatch.$versionBuild"
    }
}