#include frex:shaders/api/fragment.glsl
#include frex:shaders/lib/math.glsl

/******************************************************
  canvas:shaders/material/ethereal_glow.frag
******************************************************/

void frx_startFragment(inout frx_FragmentData fragData) {
	float b = frx_smootherstep(0.1, 0.5, dot(fragData.spriteColor.rgb, vec3(-1.0, 0.0, 0.2)));
	float l = frx_smootherstep(0.8, 1.0, frx_luminance(fragData.spriteColor.rgb));
	fragData.emissivity = max(b, l);
}