import { Dispatch, SetStateAction } from "react";
import HomeStateCardTemplate from "./HomeStateCardTemplate";
import { Recommendations } from "../models/recommendations";

export default function SolarGeneratorCard({
  onResultHook,
}: {
  onResultHook: Dispatch<SetStateAction<Recommendations>>;
}) {
  const onSubmit = () => {};

  return (
    <HomeStateCardTemplate title="Solar Generator" onSubmit={onSubmit}>
      asd
    </HomeStateCardTemplate>
  );
}
