package mod.hisui.ccb;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CCBlock extends Block {

    private static final int RGB = 255*255*255;

    public static final IntProperty COLOR = IntProperty.of("color",0,RGB);

    public CCBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(COLOR, RGB));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.setBlockState(pos, state.with(COLOR, world.random.nextInt(RGB)));
        return ActionResult.SUCCESS;
    }
}
